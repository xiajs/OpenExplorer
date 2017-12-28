import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DataConstants;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import org.apache.commons.lang.StringUtils;
import com.intellij.openapi.vfs.newvfs.impl.VirtualFileImpl;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: xiajs
 * Date: 14-3-20
 * Time: ÉÏÎç9:41
 * To change this template use File | Settings | File Templates.
 */
public class OpenExplorer extends AnAction {
    public void actionPerformed(AnActionEvent e) {
        // TODO: insert action logic here
        //System.out.println(e.getPlace());
        //com.intellij.openapi.actionSystem.DataKey<String>  keyf = new com.intellij.openapi.actionSystem.DataKey<String>("file");
        //System.out.println(e.getDataContext().getData(DataConstants.PSI_FILE));
        //System.out.println(e.getDataContext().getData(DataConstants.FILE_TEXT));
        VirtualFileImpl vf =(VirtualFileImpl)e.getDataContext().getData(PlatformDataKeys.VIRTUAL_FILE.getName());
        System.out.println(vf.getPath());
        //System.out.println(e.getDataContext().getData(DataConstants.PSI_FILE));
        openInBrowser("explorer",getPath(vf.getPath()));
    }
    protected String getPath(String s){
        if(StringUtils.isBlank(s)){
            return  "";
        }
        String ret = "";
        if(s.endsWith("/")){
           ret=s;
        }else{
           String ss = s.substring(0, s.lastIndexOf("/"));
           System.out.println(ss);
           ret=ss;
        }

        return ret.replaceAll("/","\\\\"); //ÕýÐ±¸Ü / slash Ìæ»»Îª ·´Ð±¸Ü \ backslash
    }
    protected void openInBrowser(String browser, String location) {
        try {
            Runtime.getRuntime().exec(browser + " \"" + location + "\"");
        } catch (IOException e) {

        }
    }

    public static void main(String [] args){
        String ret = "D:/eclipse/demo_web/src/com/ai/utils";
        String ret1 = ret.replaceAll("/","\\\\");

        System.out.println(ret1);
    }
}
