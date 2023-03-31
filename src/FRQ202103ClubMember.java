/*
 * Copyright (c) 2023.
 * Created by ilangxm from XDF. 964683112@qq.com vx:ilangxm
 */

import java.util.ArrayList;

class MemberInfo
{
    private String name;
    private int gradYear;
    public boolean hasGoodStanding;

    public MemberInfo(String name, int gradYear, boolean hasGoodStanding)
    {
        this.name = name;
        this.gradYear = gradYear;
        this.hasGoodStanding = hasGoodStanding;
    }

    public int getGradYear()
    {
        return gradYear;
    }

    public boolean inGoodStanding()
    {
        return hasGoodStanding;
    }

    @Override
    public String toString()
    {
        return "\n  MemberInfo{" + name + ", " + gradYear + ", " + hasGoodStanding +
                '}'  ;
    }

    public void setHasGoodStanding(boolean hasGoodStanding)
    {
        this.hasGoodStanding = hasGoodStanding;
    }
}
class ClubMembers
{
    private ArrayList<MemberInfo> memberList;


    public ClubMembers()
    {
        this.memberList = new ArrayList<>();
    }

    public void addMembers(String[] names, int gradYear)
    {
        for(String name: names)
        {
            MemberInfo info = new MemberInfo(name, gradYear, true);
            memberList.add(info);
        }
    }
    public ArrayList<MemberInfo> removeMember(int year)
    {
        ArrayList<MemberInfo> result = new ArrayList<>();

        for (int i = memberList.size()-1; i >= 0; i--)
        {
            MemberInfo member = memberList.get(i);

            if (member.getGradYear() <= year)
            {
                if (member.inGoodStanding())
                {
                    result.add(member);
                }
            }
            memberList.remove(i);
        }

        return result;
    }

    @Override
    public String toString()
    {
        return memberList + "";
    }

    public ArrayList<MemberInfo> getMemberList()
    {
        return memberList;
    }
}
public class FRQ202103ClubMember
{
    public static void main(String[] args)
    {
        ClubMembers clubMembers = new ClubMembers();

        System.out.println(clubMembers);

        String[] names = {"zhangsan", "lisi", "wangwu"};
        clubMembers.addMembers(names, 1999);
        System.out.println("After add members: ");
        System.out.println(clubMembers);

        clubMembers.addMembers(new String[]{"SMITH, JANE"},2019);
        clubMembers.getMemberList().get(0).setHasGoodStanding(false);
        clubMembers.addMembers(new String[]{"FOX, STEVE"},2018);
        clubMembers.addMembers(new String[]{"XIN, MICHAEL"},2017);
        clubMembers.getMemberList().get(2).setHasGoodStanding(false);
        clubMembers.addMembers(new String[]{"GARCIA, MARIA"},2020);

        System.out.println(clubMembers);
        System.out.println("remove grad 2018");
        System.out.println(clubMembers.removeMember(2018));
    }
}
