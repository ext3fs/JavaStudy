#JFLAGS = -g -classpath .
#JFLAGS = -encoding UTF-8 -deprecation -d . $(TARGET).java

JC	= javac
JFLAGS = -g:none -encoding UTF-8 -Xlint -deprecation

.SUFFIXES : .java .class

.java.class :	
	$(JC) $(JFLAGS) $*.java

#CLASSES = first.java	
SOURCES = main.java	
#		\ add1.java	
#		\ add3.java
#		\ add3.java

#default : classes
#classes : $(CLASSES:.java=.class)
	
default : classes 
classes : $(SOURCES:.java=.class)
	

clean :
	rm -rf *.class core*
