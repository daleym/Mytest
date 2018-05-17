package com.ym.designMode.adaptor;

/**
 *   ≈‰∆˜
 * @author Administrator
 *
 */
public class TreeElecricAdapter implements ThreeElectricOutlet {

	TwoElectricOutlet outlet;  
    public TreeElecricAdapter(TwoElectricOutlet teo) {  
        this.outlet=teo;  
    }  
      
    @Override  
    public void connectElectricCurrent() {  
        outlet.connectElectricCurrent();  
    } 

}
