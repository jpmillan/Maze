package com.jpmillan.maze;

public class Main {

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        sb.append("###########\n");
        sb.append("S #   #   #\n");
        sb.append("# # # # # #\n");
        sb.append("#   #   # #\n");
        sb.append("######### #\n");
        sb.append("# #       #\n");
        sb.append("# # #######\n");
        sb.append("# #   #   #\n");
        sb.append("# # # ### #\n");
        sb.append("#   #     F\n");
        sb.append("###########\n");

        //System.out.println(sb.toString());

        StringBuffer sb2 = new StringBuffer();
        sb2.append("###########\n");
        sb2.append("S.#...#...#\n");
        sb2.append("#.#.#.#.#.#\n");
        sb2.append("#...#...#.#\n");
        sb2.append("#########.#\n");
        sb2.append("# #.......#\n");
        sb2.append("# #.#######\n");
        sb2.append("# #...#   #\n");
        sb2.append("# # #.### #\n");
        sb2.append("#   #.....F\n");
        sb2.append("###########\n");

        //System.out.println(sb2.toString());
    }
}
