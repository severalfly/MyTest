package com.leon.memento.gameSave;

public class StateMain
{
	public static void main(String[] args)
	{
		GameRole role = new GameRole(1, 20, 400);
		role.show();

		RoleStateCaretaker caretaker = new RoleStateCaretaker();
		caretaker.setMemento(role.saveState());
		System.out.println();
		role.fight();
		role.show();

		System.out.println();
		role.recoverState(caretaker.getMemento());
		role.show();
	}
}
