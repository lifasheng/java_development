package MyJavaTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

class InformationItem {
    private String pageId;
    private String parentId;
    private String storeId;

    public InformationItem(String pageId, String parentId, String storeId) {
        this.pageId = pageId;
        this.parentId = parentId;
        this.storeId = storeId;
    }

    public String getPageId() {
        return pageId;
    }

    public void setPageId(String pageId) {
        this.pageId = pageId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    @Override
    public String toString() {
        return "InformationItem{" +
                "pageId='" + pageId + '\'' +
                ", parentId='" + parentId + '\'' +
                ", storeId='" + storeId + '\'' +
                '}';
    }
}

/**
 * This util class is to help to traverse the hierarchy of a store's navigation tree.
 *
 * For each InformationItem, it contains its pageId, parentId and storeId.
 * We will use pageId and parentId to construct the whole navigation tree.
 * Then we can easily to find a page and its children.
 *
 * For example:
 * S0 is storeId. S1 and S2's parentId is S0. S3's parentId is S1. S4 and S5's parentId is S2.
 * then the tree will be organized as:   S0->[S1,S2], S1->[S3], S2->[S4, S5]
 *
 */
class PageHierarchyOrganizer {

    /**
     * Given a page in a store, it will find the sub tree with the given page as root.
     *
     * @param pageId  a page in the store nav tree.
     * @param informationItemList information item for each page in the store.
     * @return list of information item for given page and its children.
     */
    public List<InformationItem> findChildrenIncludeSelf(final String pageId,
                                                         final List<InformationItem> informationItemList) {

        if (informationItemList.isEmpty()) {
            return new ArrayList<>();
        }

        final Map<String, List<String>> pageIdToChildrenMap = constructNavTree(informationItemList);

        final Map<String, InformationItem> pageIdToInformationItemMap = informationItemList.stream()
                .collect(Collectors.toMap(InformationItem::getPageId, Function.identity()));

        return bfsForGivenPage(pageId, pageIdToChildrenMap, pageIdToInformationItemMap);
    }

    private Map<String, List<String>> constructNavTree(final List<InformationItem> informationItemList) {
        // For each pageId, find its parent, then put itself to parent's list
        // This will construct a tree, in which each node is a pageId.
        final Map<String, List<String>> pageIdToChildMap = new HashMap<>();
        for (final InformationItem informationItem : informationItemList) {
            final List<String> childrenOfParent = pageIdToChildMap.computeIfAbsent(
                    informationItem.getParentId(), k -> new ArrayList<>());
            childrenOfParent.add(informationItem.getPageId());
        }
        return pageIdToChildMap;
    }

    private List<InformationItem> bfsForGivenPage(final String pageId,
                                                  final Map<String, List<String>> pageIdToChildrenMap,
                                                  final Map<String, InformationItem> pageIdToInformationItemMap) {
        final List<InformationItem> result = new ArrayList<>();
        final List<String> emptyChildrenList = new ArrayList<>();
        final Queue<String> queue = new LinkedList<>();
        queue.add(pageId);
        while(!queue.isEmpty()) {
            final String currentPageId = queue.remove();
            result.add(pageIdToInformationItemMap.get(currentPageId));
            // add each child of currentPageId to queue.
            pageIdToChildrenMap.getOrDefault(currentPageId, emptyChildrenList).forEach(queue::add);
        }
        return result;
    }
}

public class App
{
    private static Logger logger = LogManager.getLogger(App.class);

    public static void main(String[] args) {
        logger.info("test log4j2: welcome!");

        List<InformationItem> informationItemList = Arrays.asList(
                new InformationItem("p0", "null","p0"),
                new InformationItem("p11", "p0","p0"),
                new InformationItem("p12", "p0","p0"),
                new InformationItem("p2-11-1", "p11","p0"),
                new InformationItem("p2-11-2", "p11","p0"),
                new InformationItem("p2-12-1", "p12","p0"),
                new InformationItem("p3-12-1", "p2-12-1","p0"),
                new InformationItem("p2-11-3", "p11","p0"),
                new InformationItem("p3-11-2", "p2-11-2","p0")
                );

        while (true) {
            System.out.println("please input the pageId:");
            Scanner s = new Scanner(System.in);
            String pageId = s.next();
            if (pageId.equalsIgnoreCase("bye")) {
                break;
            }

            PageHierarchyOrganizer organizer = new PageHierarchyOrganizer();
            List<InformationItem> result = organizer.findChildrenIncludeSelf(pageId, informationItemList);
            result.forEach(System.out::println);
        }
    }
}
