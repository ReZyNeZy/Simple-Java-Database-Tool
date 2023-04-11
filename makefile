Main.class: Main.java Admin.class User.class Account.class
	javac -g Main.java

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