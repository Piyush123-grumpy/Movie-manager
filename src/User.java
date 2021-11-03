
public class User {
	private int sn;
	private String movie_name,director_name,type;
	User(int sn,String movie_name,String director_name,String type){
		this.sn=sn;
		this.movie_name=movie_name;
		this.director_name=director_name;
		this.type=type;
	}
	public int getSn() {
		return sn;
	}
	public String getMovie_name() {
		return movie_name;
	}
	public String getDirector_name() {
		return director_name;
	}
	public String getType() {
		return type;
	}
}
