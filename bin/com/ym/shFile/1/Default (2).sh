#!/bin/bash
# This shell script takes care of starting and stopping program.
#
# chkconfig: - 90 10
# description: ZYXR APP
# processname: ZYXR_APP

# Source function library.
. /etc/rc.d/init.d/functions

prog="$2"
prog_jar="$3"
prog_zkaddr="192.168.9.107:2181"
prog_zkpath="/AppConfig/ZYXR"
prog_keyword=$prog
prog_dir=/usr/local/dubbox/
prog_log_dir=$prog_dir/log/$prog
prog_gc_log=$prog_log_dir/gc.log
prog_std_log=$prog_log_dir/log.log
prog_exit_port=$prog_log_dir/$prog.port
prog_dubbo_reg_cache=$prog_log_dir/dubbo-registry-$prog.cache
prog_logconf=$prog_dir/lockbak.xml

[ -d $prog_dir ] || exit 1

RETVAL=0

##########################################################################################
JAVA_HOME=/usr/local/jdk
BASE_OPTS="-Dserver.home=$prog_dir -Djms.clientId=$prog_keyword"
if [ -f "$prog_logconf" ]; then
 JAVA_OPTS="$JAVA_OPTS -Dlogback.configurationFile=$prog_logconf"
fi
JAVA_OPTS="$JAVA_OPTS -DLocalStop.Port=$prog_exit_port -Ddubbo.registry.file=$prog_dubbo_reg_cache"
JAVA_OPTS="$JAVA_OPTS -Xbootclasspath/a:$prog_dir/lib/tomcat-dbcp-7.0.70.jar:$prog_dir/lib/tomcat-servlet-api-7.0.70.jar"
JOPTS="$4"
if [ -z "$JOPTS" ]; then
  JAVA_OPTS="$JAVA_OPTS -server -Xms64M -Xmx512M -XX:MetaspaceSize=128M -XX:MaxMetaspaceSize=256M -Xss256k"
else
  JAVA_OPTS="$JAVA_OPTS $JOPTS"
fi
#JAVA_OPTS="$JAVA_OPTS -server -Xms64M -Xmx512M -XX:MetaspaceSize=128M -XX:MaxMetaspaceSize=256M -Xss256k"
JAVA_OPTS="$JAVA_OPTS -XX:+UseG1GC -XX:MaxGCPauseMillis=200 -XX:ParallelGCThreads=20 -XX:ConcGCThreads=5 -XX:InitiatingHeapOccupancyPercent=50"
JAVA_OPTS="$JAVA_OPTS -XX:+PrintGC -XX:+PrintHeapAtGC -XX:+PrintGCDetails -XX:+PrintGCDateStamps"
JAVA_OPTS="$JAVA_OPTS -XX:+PrintGCTimeStamps -XX:+PrintGCCause"
JAVA_OPTS="$JAVA_OPTS -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=$prog_log_dir/"
JAVA_OPTS="$JAVA_OPTS -Xloggc:$prog_gc_log"
JAVA_OPTS="$JAVA_OPTS $BASE_OPTS"
##########################################################################################


if [ ! -d $JAVA_HOME ];then
     echo "JAVA_HOME Not defined";
     exit 1
fi


start() {
    prog_pid=`ps ax | grep -v grep | grep "clientId=$prog_keyword" | awk '{print $1}'`
    prog_num=`ps ax | grep -v grep | grep "clientId=$prog_keyword" | wc -l`
    if [ $prog_num != "0" ];then
        echo $prog" already running...."
        exit 1
    fi

    [ -d $prog_log_dir ] || mkdir -p $prog_log_dir

    [ -f $prog_gc_log ] && rm -rf $prog_gc_log || touch $prog_gc_log

    echo -n $"Starting $prog "
    cd $prog_dir
    nohup $JAVA_HOME/bin/java $JAVA_OPTS -jar $prog_jar $prog_zkaddr $prog_zkpath >> $prog_std_log 2>&1 &
    sleep 5s
    prog_num=`ps ax | grep -v grep | grep java | grep "clientId=$prog_keyword" | wc -l`
    if [ $prog_num != "0" ];then
        RETVAL=0
        success
        echo
    else
        RETVAL=1
        failure
        echo
    fi
    return $RETVAL
}



stop() {
    prog_pid=`ps ax | grep -v grep | grep "clientId=$prog_keyword" | awk '{print $1}'`
    prog_num=`ps ax | grep -v grep | grep "clientId=$prog_keyword" | wc -l`
    echo -n $"Shutting down $prog "
    if [ $prog_num = "0" ];then
          RETVAL="1"
    else
        $JAVA_HOME/bin/java $JAVA_OPTS -DLocalStop.Exit=Stop -jar $prog_jar $prog_zkaddr $prog_zkpath >> $prog_std_log 2>&1 &
        for ((i=0;i<120;i++))
        do
          sleep 1s
          prog_num=`ps ax | grep -v grep | grep "clientId=$prog_keyword" | wc -l`
          if [ $prog_num != "0" ];then
            RETVAL="1"
          else
              RETVAL=0
              break
          fi
       done

       prog_num=`ps ax | grep -v grep | grep "clientId=$prog_keyword" | wc -l`
       if [ $prog_num != "0" ];then
            kill -9 $prog_pid 2>&1 > /dev/null
            RETVAL=$?
       else
           RETVAL=0
       fi
    fi
   

    if [ $RETVAL -eq 0 ];then
          [ -f $prog_gc_log ] && rm -rf $prog_gc_log || touch $prog_gc_log
          success
          echo
    else
          failure
          echo
    fi
    return $RETVAL
}



status() {
    prog_pid=`ps ax | grep -v grep | grep "clientId=$prog_keyword" | awk '{print $1}'`
    prog_num=`ps ax | grep -v grep | grep "clientId=$prog_keyword" | wc -l`
    if [ $prog_num != "0" ];then
          echo "$prog (pid $prog_pid) is running..."
          return 0
    else
          echo "$prog is stopped"
          return 3
    fi
}





case "$1" in
        start)
            start
            ;;
        stop)
            stop
            ;;
        status)
            status
            ;;
        restart)
            stop
            start
            ;;
        *)
            echo "Usage: $0 {start|stop|status|restart}"
            exit 1
esac
exit $RETVAL








