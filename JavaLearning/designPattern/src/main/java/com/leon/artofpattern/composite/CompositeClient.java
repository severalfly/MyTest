package com.leon.artofpattern.composite;

public class CompositeClient
{
	public static void main(String[] args)
	{
		AbstractFile file1, file2, file3, file4, file5, folder1, folder2, folder3, folder4;
		folder1 = new Folder("sunny's document");

		folder2 = new Folder("image files");
		folder3 = new Folder("text files");
		folder4 = new Folder("video files");

		file1 = new ImageFile("小龙女.jpg");
		file2 = new ImageFile("leon.gif");

		file3 = new TextFile("九阴真经.txt");
		file4 = new TextFile("葵花宝典.doc");
		file5 = new VideoFile("笑傲江湖.rmvb");

		folder2.add(file1);
		folder2.add(file2);

		folder3.add(file3);
		folder3.add(file4);
		folder4.add(file5);

		folder1.add(folder2);
		folder1.add(folder3);
		folder1.add(folder4);

		folder1.killVirus();
		//		folder2.killVirus();
		//		file1.killVirus();
	}
}
