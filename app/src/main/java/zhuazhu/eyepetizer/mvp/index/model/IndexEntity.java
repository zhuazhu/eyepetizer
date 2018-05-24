package zhuazhu.eyepetizer.mvp.index.model;

import java.util.List;

/**
 * @author zhuazhu
 **/
public class IndexEntity {

    private String nextPageUrl;
    private long nextPublishTime;
    private String newestIssueType;
    private List<Issue> issueList;

    public String getNextPageUrl() {
        return nextPageUrl;
    }

    public void setNextPageUrl(String nextPageUrl) {
        this.nextPageUrl = nextPageUrl;
    }

    public long getNextPublishTime() {
        return nextPublishTime;
    }

    public void setNextPublishTime(long nextPublishTime) {
        this.nextPublishTime = nextPublishTime;
    }

    public String getNewestIssueType() {
        return newestIssueType;
    }

    public void setNewestIssueType(String newestIssueType) {
        this.newestIssueType = newestIssueType;
    }

    public List<Issue> getIssueList() {
        return issueList;
    }

    public void setIssueList(List<Issue> issueList) {
        this.issueList = issueList;
    }

    public class Issue{
        private List<Item> itemList;

        public List<Item> getItemList() {
            return itemList;
        }

        public void setItemList(List<Item> itemList) {
            this.itemList = itemList;
        }
    }
    public class Item{
        private String type;
        private Data data;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Data getData() {
            return data;
        }

        public void setData(Data data) {
            this.data = data;
        }
    }
    public class Data{
        private String title;
        private String description;
        private String slogan;
        private String playUrl;
        private int duration;
        private Cover cover;
        private Author author;
        private String category;

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getSlogan() {
            return slogan;
        }

        public void setSlogan(String slogan) {
            this.slogan = slogan;
        }

        public String getPlayUrl() {
            return playUrl;
        }

        public void setPlayUrl(String playUrl) {
            this.playUrl = playUrl;
        }

        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }

        public Cover getCover() {
            return cover;
        }

        public void setCover(Cover cover) {
            this.cover = cover;
        }

        public Author getAuthor() {
            return author;
        }

        public void setAuthor(Author author) {
            this.author = author;
        }
    }
    public class Author{
        private String name;
        private String icon;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }
    }
    public class Cover{

        private String feed;
        private String detail;
        private String blurred;
        private String sharing;
        private String homepage;

        public String getFeed() {
            return feed;
        }

        public void setFeed(String feed) {
            this.feed = feed;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }

        public String getBlurred() {
            return blurred;
        }

        public void setBlurred(String blurred) {
            this.blurred = blurred;
        }

        public String getSharing() {
            return sharing;
        }

        public void setSharing(String sharing) {
            this.sharing = sharing;
        }

        public String getHomepage() {
            return homepage;
        }

        public void setHomepage(String homepage) {
            this.homepage = homepage;
        }
    }
}
