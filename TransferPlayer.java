package alexLiu.exercise;

import java.util.ArrayList;

public class TransferPlayer {

	private String name;
	private String year;
	private String pos;
	private String height;
	private String weight;
	private String pts;
	private String rebs;
	private String asts;
	private String school;
	
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getPos() {
		return pos;
	}
	public void setPos(String pos) {
		this.pos = pos;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getPts() {
		return pts;
	}
	public void setPts(String pts) {
		this.pts = pts;
	}
	public String getRebs() {
		return rebs;
	}
	public void setRebs(String rebs) {
		this.rebs = rebs;
	}
	public String getAsts() {
		return asts;
	}
	public void setAsts(String asts) {
		this.asts = asts;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName(){
		return name;
	}
	
	public TransferPlayer(String rowString){
		String[] split = rowString.split(" ");
		name = split[0] + " " + split[1];
		int i = split.length-1;
		ArrayList<String> schoolArr = new ArrayList<String>();
		school = " ";
		while(!split[i].equals("YES")){
			schoolArr.add(split[i]);
			i--;
		}
		i--;		
		for(int j = schoolArr.size()-1; j>=0; j--){
			school += schoolArr.get(j) + " ";
		}
		asts = split[i];
		i--;
		rebs = split[i];
		i--;
		pts = split[i];
		i--;
		weight = split[i];
		i--;
		height = split[i];
		i--;
		pos = split[i];
		i--;
		i--;
		year = "";
		if(split[i].contains("RS")){
			year += split[i] + " ";
		}
		i++;
		year += split[i];
	}
	@Override
	public String toString(){
		String answer = "";
		answer += name + " ";
		answer += year + " ";
		answer += pos + " ";
		answer += height + " ";
		answer += weight + " ";
		answer += pts + " ";
		answer += rebs + " ";
		answer += asts + " ";
		answer += school + " ";
		return answer;
	}

}
