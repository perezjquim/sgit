FILES := $(shell find . -name "*.java")
main: compile exec
compile:
	@echo 'Compiling..'
	@javac -d bin $(FILES)
	@jar -cvmf manifest.txt sgit.jar -C bin . > /dev/null
exec:
	@echo 'Executing..'
	@java -jar sgit.jar
