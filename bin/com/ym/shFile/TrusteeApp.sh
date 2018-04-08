#!/bin/bash
# This shell script takes care of starting and stopping program.
#
# chkconfig: - 90 10
# description: ZYXR APP
# processname: ZYXR_APP

# Source function library.
. /etc/rc.d/init.d/functions


prog="TrusteeApp"
prog_jar="$prog-0.0.1-SNAPSHOT.jar"

user=appadmin
SCRIPT="$(readlink --canonicalize-existing "$0")"
BASEDIR="$(dirname "$SCRIPT")"
ThisUser=`whoami`
ISInUser=0
if [ $ThisUser == $user ]; then
   ISInUser=1
fi



case "$1" in
        start)
	    if [ $ISInUser -eq 1 ]; then
   		$BASEDIR/Default.sh start $prog $prog_jar
	    else
   		su $user -c "$BASEDIR/Default.sh start $prog $prog_jar"
	    fi
            ;;
        stop)
            if [ $ISInUser -eq 1 ]; then
                $BASEDIR/Default.sh stop $prog $prog_jar
            else
                su $user -c "$BASEDIR/Default.sh stop $prog $prog_jar"
            fi
            ;;
        status)
            if [ $ISInUser -eq 1 ]; then
                $BASEDIR/Default.sh status $prog $prog_jar
            else
                su $user -c "$BASEDIR/Default.sh status $prog $prog_jar"
            fi
            ;;
        restart)
	    if [ $ISInUser -eq 1 ]; then
                $BASEDIR/Default.sh stop $prog $prog_jar
		$BASEDIR/Default.sh start $prog $prog_jar
            else
                su $user -c "$BASEDIR/Default.sh stop $prog $prog_jar"
                su $user -c "$BASEDIR/Default.sh start $prog $prog_jar"
            fi
            ;;
        *)
            echo "Usage: $0 {start|stop|status|restart}"
            exit 1
esac
exit $RETVAL







