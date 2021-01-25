package com.stablemarriage;

import java.util.ArrayList;
import java.util.List;

public class marriage {


	/*public static void main(String[] args) 
	{
		list boy = new list ("boys.txt");
		
		System.out.println();
		
		list girl = new list ("girls.txt");
		
		System.out.println(boy.capacity);
		
	}*/

}
/*
While  存在M中存在单身男性m_i
      在m_i还没求过婚的女性中选择最为喜欢的一个f_j求婚
        If  f_j 是单身的  Then
           m_i与f_j订婚组成（m_i,f_j）
        Else  f_j已经和m_k订婚组成（m_k,f_j）
           If  g(f_j,m_k) < g(f_j,m_i) （即f_j更喜欢m_k） Then
              m_i继续单身
           Else g(f_j,m_k) > g(f_j,m_i) （即f_j更喜欢m_i）
              m_i与f_j订婚组成配对（m_i,f_j）
              m_k变成单身
           End if
        End if
    End while
*/