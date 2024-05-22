package assignment14.assignment10;

public class WebPage {
	String pageId;
	String url;
	String title;
	String visitDate;
	public WebPage(String pageId, String url, String title, String visitDate) {
		super();
		this.pageId = pageId;
		this.url = url;
		this.title = title;
		this.visitDate = visitDate;
	}
	public String getPageId() {
		return pageId;
	}
	public void setPageId(String pageId) {
		this.pageId = pageId;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getVisitDate() {
		return visitDate;
	}
	public void setVisitDate(String visitDate) {
		this.visitDate = visitDate;
	}
	@Override
	public String toString() {
		return "WebPage [pageId=" + pageId + ", url=" + url + ", title=" + title + ", visitDate=" + visitDate + "]";
	}
	
		
}
