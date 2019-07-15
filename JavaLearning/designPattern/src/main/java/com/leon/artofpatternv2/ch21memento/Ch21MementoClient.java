package com.leon.artofpatternv2.ch21memento;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class Ch21MementoClient
{
	public static void main(String[] args)
	{
		MementoCaretaker caretaker = new MementoCaretaker();
		Chessmen chess = new Chessmen("car", 1, 1);
		display(chess);
		caretaker.getMementos().add(chess.save());
		chess.setY(4);
		display(chess);
		caretaker.getMementos().add(chess.save());
		chess.setX(5);
		display(chess);
		caretaker.getMementos().add(chess.save());
		System.out.println("---悔棋---");
		chess.restore(caretaker.getMementos());
		display(chess);
		chess.restore(caretaker.getMementos());
		display(chess);		chess.restore(caretaker.getMementos());
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

	public void restore(List<ChessmanMemento> mementos)
	{
		ChessmanMemento memento = mementos.get(mementos.size() - 1);
		this.label = memento.getLabe();
		this.x = memento.getX();
		this.y = memento.getY();
		mementos.remove(mementos.size() - 1);
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
	private List<ChessmanMemento> mementos;

	public MementoCaretaker()
	{
		this.mementos = new ArrayList<>();
	}

}