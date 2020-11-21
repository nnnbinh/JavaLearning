package diary;

public class DiaryModel {
	private String sContent;
	private String sDate;

	public DiaryModel(String content,String date) {
		// TODO Auto-generated constructor stub
		this.sContent=content;
		this.sDate=date;
	}

	public String getsContent() {
		return sContent;
	}

	public void setsContent(String sContent) {
		this.sContent = sContent;
	}

	public String getsDate() {
		return sDate;
	}

	public void setsDate(String sDate) {
		this.sDate = sDate;
	}
	

}
