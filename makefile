Main.class: Admin.class Account.class Database.class
	javac -g Main.java

Database.class:
	javac -g Database.java

Admin.class:
	javac -g Admin.java

Account.class:
	javac -g Account.java

clean:
	rm *.class

run: Main.class
	java Main