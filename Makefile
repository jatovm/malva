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
CLASSES	+= src/malva/java/lang/ClassLoaderTest.class
CLASSES	+= src/malva/java/lang/DoubleTest.class
CLASSES	+= src/malva/java/lang/FloatTest.class
CLASSES	+= src/malva/java/lang/MathTest.class
CLASSES	+= src/malva/java/lang/StringTest.class
CLASSES += src/malva/java/io/PrintStreamTest.class
CLASSES += src/malva/java/lang/ClassTest.class
CLASSES += src/malva/java/lang/ObjectTest.class
CLASSES += src/malva/java/lang/ProcessTest.class
CLASSES += src/malva/java/lang/RuntimeTest.class
CLASSES += src/malva/java/lang/SystemTest.class
CLASSES += src/malva/java/lang/ThreadTest.class
CLASSES += src/malva/java/lang/ThrowableTest.class
CLASSES += src/malva/java/lang/invoke/MethodHandleTest.class
CLASSES += src/malva/java/lang/invoke/MethodTypeTest.class
CLASSES += src/malva/java/net/InetAddressTest.class
CLASSES += src/malva/java/net/NetworkInterfaceTest.class
CLASSES += src/malva/java/nio/DirectByteBufferTest.class
CLASSES += src/malva/java/util/regex/PatternTest.class

SRC	:= $(patsubst %.class,%.java,$(CLASSES))

%.class: %.java
	$(E) "  JAVAC   " $<
	$(Q) $(JAVAC) -g -Xlint:unchecked -source 1.7 -target 1.7 -encoding utf8 -cp src $<

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
