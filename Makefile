# External programs
JAVA	?= java
JAVAC	?= javac

export JAVA

# Make the build silent by default
V =
ifeq ($(strip $(V)),)
	E = @echo
	Q = @
else
	E = @\#
	Q =
endif
export E Q

CLASSES	+= src/malva/TestCase.class
CLASSES	+= src/malva/java/lang/ClassTest.class
CLASSES	+= src/malva/java/lang/StringTest.class

SRC	:= $(patsubst %.class,%.java,$(CLASSES))

%.class: %.java
	$(E) "  JAVAC   " $<
	$(Q) $(JAVAC) -g -Xlint:unchecked -source 1.6 -target 1.6 -encoding utf8 -cp src $<

all: $(CLASSES)
.PHONY: all

check: $(CLASSES)
	$(E) "  CHECK"
	$(Q) ./scripts/suite
.PHONY: check

clean:
	$(E) "  CLEAN"
	$(Q) - find src/ -name "*.class" | xargs rm -f
.PHONY: clean
