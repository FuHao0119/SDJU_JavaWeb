package cn.edu.sdju.soft;

import java.util.HashMap;
import java.util.Map;

/**
 * 投票数据工具类：全局管理投票结果，提供票数统计和百分比计算功能
 */
public class VoteUtil {
    public static final String[] OPTIONS = {
        "篮球", "排球", "音乐", "游泳", "足球", "乒乓球", "羽毛球", "滑冰", "其他"
    };
    
    private static Map<String, Integer> voteCount = new HashMap<>();
    static {
        for (String option : OPTIONS) {
            voteCount.put(option, 0);
        }
    }
    public static void addVote(String[] selectedOptions) {
        if (selectedOptions == null || selectedOptions.length == 0) {
            return; // 未选任何选项，不处理
        }
        for (String option : selectedOptions) {
            if (voteCount.containsKey(option)) {
                voteCount.put(option, voteCount.get(option) + 1); // 票数+1
            }
        }
    }
    
    /**
     * 计算总投票数
     * @return 所有选项的票数之和
     */
    public static int getTotalVotes() {
        int total = 0;
        for (int count : voteCount.values()) {
            total += count;
        }
        return total;
    }
    
    /**
     * 获取指定选项的票数
     * @param option 选项名
     * @return 该选项的票数（默认0）
     */
    public static int getVoteCount(String option) {
        return voteCount.getOrDefault(option, 0);
    }
    
    /**
     * 计算指定选项的得票百分比（用于进度条宽度）
     * @param option 选项名
     * @return 百分比（如72表示72%），无投票时返回0
     */
    public static int getVoteRate(String option) {
        int total = getTotalVotes();
        if (total == 0) {
            return 0; // 避免除以0
        }
        int count = getVoteCount(option);
        return (int) ((double) count / total * 100); // 转换为整数百分比
    }
}
