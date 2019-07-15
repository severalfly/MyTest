package com.leon.artofpatternv2.ch21memento;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Ch21MementoClient
{
	public static void main(String[] args)
	{
		MementoCaretaker caretaker = new MementoCaretaker();
		Chessmen chess = new Chessmen("car", 1, 1);
		display(chess);
		caretaker.setMemento(chess.save());
		chess.setY(4);
		display(chess);
		caretaker.setMemento(chess.save());
		display(chess);
		chess.setX(5);
		display(chess);
		System.out.println("---悔棋---");
		chess.restore(caretaker.getMemento());
		display(chess);
	}

	public static void display(Chessmen chess)
	{
		System.out.println(chess);
	}

}

@Setter
@Getter
class Chessmen
{
	private String label;
	private int x;
	private int y;

	public Chessmen(String label, int x, int y)
	{
		this.label = label;
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("棋子：");
		sb.append(label);
		sb.append(" 当前位置，x: ");
		sb.append(x);
		sb.append(", y: ");
		sb.append(y);

		return sb.toString();
	}

	public ChessmanMemento save()
	{
		return new ChessmanMemento(this.label, this.x, this.y);
	}

	public void restore(ChessmanMemento memento)
	{
		this.label = memento.getLabe();
		this.x = memento.getX();
		this.y = memento.getY();
	}

}

@Setter
@Getter
class ChessmanMemento
{
	private String labe;
	private int x;
	private int y;

	public ChessmanMemento(String labe, int x, int y)
	{
		this.labe = labe;
		this.x = x;
		this.y = y;
	}
}

@Setter
@Getter
class MementoCaretaker
{
	private ChessmanMemento memento;

}