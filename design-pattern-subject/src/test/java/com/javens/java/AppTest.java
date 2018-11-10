package com.javens.java;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.javens.java.design.light.DesignRedGreenYellowLight;
import com.javens.java.design.light.LightCondition;
import com.javens.java.design.light.enums.LightButtonEnum;
import com.javens.java.design.light.enums.LightEnum;
import com.javens.java.design.light.model.Light;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testLight(){
        DesignRedGreenYellowLight designRedGreenYellowLight = new DesignRedGreenYellowLight();
        List<LightCondition> list = new ArrayList<LightCondition>();
        //all off
        list.add(new LightCondition(new Light(LightEnum.RED, LightButtonEnum.OFF),
                new Light(LightEnum.GREEN, LightButtonEnum.OFF),
                new Light(LightEnum.YELLOW, LightButtonEnum.OFF)));
        //绿灯熄灭、黄灯亮
        list.add(new LightCondition(
                new Light(LightEnum.GREEN, LightButtonEnum.OFF),
                new Light(LightEnum.YELLOW, LightButtonEnum.ON)));

        // 黄灯熄灭、红灯亮
        list.add(new LightCondition(
                new Light(LightEnum.RED, LightButtonEnum.ON),
                new Light(LightEnum.YELLOW, LightButtonEnum.OFF)));
        //all ON
        list.add(new LightCondition(new Light(LightEnum.RED, LightButtonEnum.ON),
                new Light(LightEnum.GREEN, LightButtonEnum.ON),
                new Light(LightEnum.YELLOW, LightButtonEnum.ON)));
        designRedGreenYellowLight.setList(list);



        assertTrue( designRedGreenYellowLight.open(new Light(LightEnum.RED, LightButtonEnum.OFF),
                new Light(LightEnum.GREEN, LightButtonEnum.OFF),
                new Light(LightEnum.YELLOW, LightButtonEnum.OFF)));
        assertTrue( designRedGreenYellowLight.open(new Light(LightEnum.RED, LightButtonEnum.OFF),
                new Light(LightEnum.GREEN, LightButtonEnum.OFF),
                new Light(LightEnum.YELLOW, LightButtonEnum.ON)));
        assertTrue( designRedGreenYellowLight.open(new Light(LightEnum.RED, LightButtonEnum.ON),
                new Light(LightEnum.GREEN, LightButtonEnum.OFF),
                new Light(LightEnum.YELLOW, LightButtonEnum.OFF)));
        assertTrue( designRedGreenYellowLight.open(new Light(LightEnum.RED, LightButtonEnum.ON),
                new Light(LightEnum.GREEN, LightButtonEnum.ON),
                new Light(LightEnum.YELLOW, LightButtonEnum.ON)));

        //不在条件里面(红灯熄灭，绿灯量)
        assertFalse( designRedGreenYellowLight.open(new Light(LightEnum.RED, LightButtonEnum.OFF),
                new Light(LightEnum.GREEN, LightButtonEnum.ON),
                new Light(LightEnum.YELLOW, LightButtonEnum.OFF)));
    }
}
