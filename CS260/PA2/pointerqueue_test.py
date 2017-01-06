#!/usr/bin/env python

# Author: David Tigreros
# 8/10/2016
# CS-260 Section-003
# Dr. Nowak
# Programming Assignment 2
# Test class for pointer queue

import pointerqueue

# main method to test functions
def main():
   test = pointerqueue.ptr_queue()
   pointerqueue.ENQUEUE(1,test)
   pointerqueue.ENQUEUE(2,test)
   pointerqueue.ENQUEUE(3,test)
   pointerqueue.ENQUEUE(4,test)
   pointerqueue.ENQUEUE(5,test)
   pointerqueue.PRINT(test)
   print "Test Front (expect 1): "
   print pointerqueue.FRONT(test)
   print "Test Dequeue (expect to remove 1): "
   pointerqueue.DEQUEUE(test)
   pointerqueue.PRINT(test)
   print "Test empty (expect false): "
   print pointerqueue.EMPTY(test)
   print "Test Makenull: "
   test = pointerqueue.MAKENULL(test)
   pointerqueue.PRINT(test)
   print "Test Empty (expect true): "
   print pointerqueue.EMPTY(test)

main()
