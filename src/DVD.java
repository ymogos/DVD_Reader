public class DVD {
	private int Id=0;
	private String title;
    private String date;
    private int mpaaRating;
    private String DirectorName;
    private String Studio;
    private String UserRating;
    public DVD() {
    	
    }

    
     public DVD(int id,String title, String date, int mpaaRating, String directorName, String studio,
			String userRating) {
		super();
		this.title = title;
		this.date = date;
		this.mpaaRating = mpaaRating;
		this.DirectorName = directorName;
		this.Studio = studio;
		this.UserRating = userRating;
		this.Id= id;
	}
	public int getId() {
		return this.Id;
	}


	public void setId(int id) {
		this.Id = id;
	}


	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDate() {
		return this.date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getMpaaRating() {
		return this.mpaaRating;
	}
	public void setMpaaRating(int mpaaRating) {
		this.mpaaRating = mpaaRating;
	}
	public String getDirectorName() {
		return this.DirectorName;
	}
	public void setDirectorName(String directorName) {
		this.DirectorName = directorName;
	}
	public String getStudio() {
		return this.Studio;
	}
	public void setStudio(String studio) {
		this.Studio = studio;
	}
	public String getUserRating() {
		return this.UserRating;
	}
	public void setUserRating(String userRating) {
		this.UserRating = userRating;
	}

	@Override
	public String toString() {
		return this.Id + "\t\t"+ this.title + "\t\t" + this.date + "\t\t" + this.mpaaRating + "\t\t"
				+ this.DirectorName + "\t\t" + this.Studio + "\t\t" + this.UserRating;
	}
     
	
}