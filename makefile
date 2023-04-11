Main.class: Main.java Admin.class User.class Account.class Database.class
	javac -g Main.java

Database.class:
	javac -g Database.java

Admin.class:
	javac -g Admin.java

User.class:
	javac -g User.java

Account.class:
	javac -g Savings.java

clean:
	rm *.class

run: Main.class
	java Main