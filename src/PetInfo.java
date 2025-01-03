import java.util.HashMap;
import java.util.HashSet;

import javax.swing.ImageIcon;

import utils.EAttribute;
import utils.EElement;

public class PetInfo {
    public static final int MAX_LV=100;//最大等级
    public Integer id=0;//
    public String name="";//
    public utils.EPetSex sex= utils.EPetSex.NONE;
    public String introduction="";//简介

    //TODO:加入技能

    public HashMap<EAttribute,Integer> attributes=new HashMap<EAttribute,Integer>();//属性值 键值对
    public HashSet<EElement> elements=new HashSet<EElement>();
    public ImageIcon headImage;//头像


}
