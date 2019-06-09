package com.leon.memento.gameSave;

public class GameRole
{
	private int vit;// 生命力
	private int atk;// 攻击力
	private int def;// 防御力

	public GameRole(int vit, int atk, int def)
	{
		super();
		this.vit = vit;
		this.atk = atk;
		this.def = def;
	}

	public void show()
	{
		System.out.println("生命力" + this.vit);
		System.out.println("攻击力" + this.atk);
		System.out.println("防御力" + this.def);
	}

	/**
	 * 模拟战斗，全部力量规0
	 */
	public void fight()
	{
		this.vit = 0;
		this.atk = 0;
		this.def = 0;
	}

	public RoleStateMemento saveState()
	{
		return new RoleStateMemento(this.vit, this.atk, this.def);
	}

	public void recoverState(RoleStateMemento memento)
	{
		this.vit = memento.getVit();
		this.atk = memento.getAtk();
		this.def = memento.getDef();
	}

	public int getVit()
	{
		return vit;
	}

	public void setVit(int vit)
	{
		this.vit = vit;
	}

	public int getAtk()
	{
		return atk;
	}

	public void setAtk(int atk)
	{
		this.atk = atk;
	}

	public int getDef()
	{
		return def;
	}

	public void setDef(int def)
	{
		this.def = def;
	}

}
