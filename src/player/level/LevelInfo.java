package player.level;

public interface LevelInfo {
	double getMoney();
	double getScore();
	double getHealth();
	void updateDroppable(String id);
}
