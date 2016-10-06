CC = g++
CFLAGS  = -g -Wall
PAGER = less
# the build target executable:
TARGET = cddb

all: $(TARGET)

$(TARGET): cddb.h cddb.cpp
	$(CC) $(CFLAGS) -o $(TARGET) cddb.h cddb.cpp
	$(PAGER) cddb.h
	$(PAGER) cddb.cpp
clean:
	$(RM) $(TARGET)

