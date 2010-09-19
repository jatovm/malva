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

SRC	:= $(patsubst %.class,%.java,$(CLASSES))

%.class: %.java
	$(E) "  JAVAC   " $<
	$(Q) $(JAVAC) -g -source 1.6 -target 1.6 -cp src $<

all: $(CLASSES)
.PHONY: all

check: $(CLASSES)
	$(E) "  CHECK"
	$(Q) $(SHELL) ./scripts/suite
.PHONY: check

clean:
	$(E) "  CLEAN"
	$(Q) rm -f $(CLASSES)
.PHONY: clean
