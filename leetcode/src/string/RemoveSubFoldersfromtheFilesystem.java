package string;

import java.util.*;

/**
 * @Author: Usher
 * @Date: 2019/11/2,0002
 * @Description:
 */
public class RemoveSubFoldersfromtheFilesystem {

    public List<String> removeSubfolders(String[] folder) {

        Arrays.sort(folder);
        Set<String> res = new HashSet<>(Arrays.asList(folder));

        for (int i = 0; i < folder.length-1; i++) {
            if (res.contains(folder[i])) {
                for (int j = i+1; j < folder.length; j++) {
                    if (folder[j].contains(folder[i] + '/')) {
                        res.remove(folder[j]);
                    }
                }
            }

        }
        return new ArrayList<>(res);
    }

    public List<String> removeSubfolders2(String[] folders) {
        Set<String> parents = new HashSet<>(Arrays.asList(folders));
        List<String> dest=new ArrayList<>();

        for (String folder:folders) {
            if (contains(parents, folder)) {
                continue;
            }
            dest.add(folder);
        }

        return dest;
    }

    private boolean contains(Set<String> parents, String folder) {
        int index=folder.indexOf("/");
        while(index!=-1) {
            if(parents.contains(folder.substring(0,index))) {
                return true;
            }
            index=folder.indexOf("/", index+1);
        }
        return false;
    }
}
