#-----------------------------------------------------------------
# Fox-Goose-Corn example, v.0.3
# JL Popyack, July 2008
# Revised April 2009
#   v.0.2 - simplified member(x,L)
#   v.0.3 - added numSteps
#
# A farmer must transport a fox, a goose, and some corn across a
# river. He can take at most one passenger in the boat in addition
# to himself, and is permitted to take as many trips back and
# forth across the river as are necessary. He knows that the fox
# will eat the goose if left unattended, and likewise, the goose
# will eat the corn.
#-----------------------------------------------------------------

#-----------------------------------------------------------------
# These provide some LISP-like functionality.
#-----------------------------------------------------------------

def first(list):
    return list[0]

def rest(list):
    return list[1:]

def member(x,L):
	return x in L

#-----------------------------------------------------------------
# Problem Representation:
# The state is a 4-tuple containing the number of each kind of
# occupant on the left bank (rive gauche).  Specifically, it is
# [#farmers,#foxes,#geese,#corn], where the number can be either
# 0 or 1
#-----------------------------------------------------------------

#-----------------------------------------------------------------
# This is a list of all possible states of the system.  It is not
# used for solving the problem, but for testing only.
#-----------------------------------------------------------------

allStates = [[1,1,1,1],[1,1,1,0],[1,1,0,1],[1,1,0,0],
             [1,0,1,1],[1,0,1,0],[1,0,0,1],[1,0,0,0],
             [0,1,1,1],[0,1,1,0],[0,1,0,1],[0,1,0,0],
             [0,0,1,1],[0,0,1,0],[0,0,0,1],[0,0,0,0]]

#-----------------------------------------------------------------
# A rule is a 4-tuple containing the number of each kind of
# occupant to move from the left bank to the right bank (rive
# droite).  Specifically, it is [#farmers,#foxes,#geese,#corn],
# where the number can be -1, 0 or 1.  (-1 indicates the movement
# is from right to left - a rule can be applied by adding it to
# the state.
#-----------------------------------------------------------------

allRules = [[-1,0,0,0],[-1,-1,0,0],[-1,0,-1,0],[-1,0,0,-1],
            [ 1,0,0,0],[ 1, 1,0,0],[ 1,0, 1,0],[ 1,0,0, 1]]

initialState = allStates[0]

#-----------------------------------------------------------------
# The goal is to get all occupants to the right bank, so the
# desired final state is [0,0,0,0]
#-----------------------------------------------------------------
def goal(state):
    return state == [0,0,0,0]

#-----------------------------------------------------------------
# Returns True if s represents a "feasting" state
#-----------------------------------------------------------------
def feast(s):
    if s[0]==1 and s[1]==0 and s[2]==0:
        return True
    if s[0]==1 and s[2]==0 and s[3]==0:
        return True
    if s[0]==0 and s[1]==1 and s[2]==1:
        return True
    if s[0]==0 and s[2]==1 and s[3]==1:
        return True

    return False

#-----------------------------------------------------------------
# Returns True if rule may legally be applied to state
#-----------------------------------------------------------------
def preCondition(state,rule):
    temp = applyRule(state,rule)
    for i in temp:
        if i<0 or i>1:   # illegal state produced; can't apply rule
            return False
    return not feast(temp) # legal state produced, but is there a feast?


#-----------------------------------------------------------------
# Apply rule to state
#-----------------------------------------------------------------
def applyRule(state,rule):
    result = range(len(state)) # create array of desired size
    for i in range(len(state)):
        result[i] = state[i] + rule[i]
    return result


#-----------------------------------------------------------------
# Find all applicable rules for a given state
#-----------------------------------------------------------------
def applicableRules(state):
    result = []
    for r in allRules:
        if preCondition(state,r):
            result.append(r)
    return result


#-----------------------------------------------------------------
# English descriptions of states and rules
#-----------------------------------------------------------------

name = ["farmer","fox","goose","corn"]

def describeState(state):
    description = "[["
    for i in range(len(state)):  #occupants of left bank
        if state[i] == 1:
            description = description + " " + name[i]
    description += " ]["
    for i in range(len(state)):  #occupants of left bank
        if state[i] == 0:
            description = description + " " + name[i]
    description += " ]]"
    return description

def describeRule(rule):
    fromBank = "Left"
    toBank = "Right"
    if rule[0]==1:
        fromBank = "Right"
        toBank = "Left"

    item = ""
    for i in range(len(rule)):
        if i>0 and rule[i]==rule[0]:
            item = name[i]

    if item <> "":
        item = " and " + item
    description = "Move farmer" + item + " from " + fromBank + " to " + toBank
    return description

#-----------------------------------------------------------------
# TESTING:
# -------
# Test preCondition code
#-----------------------------------------------------------------

##for s in allStates:
##    for r in allRules:
##        if preCondition(s,r):
##            print "Can apply %s to %s . Feast=%s" %(r,s,feast(applyRule(s,r)))
##        else:
##            print "Can't apply %s to %s . Feast=%s" %(r,s,feast(applyRule(s,r)))

#-----------------------------------------------------------------
# TESTING:
# -------
# Test goal code
#-----------------------------------------------------------------
##for s in allStates:
##    print "s = %s ; goal(s)=%s" %(s,goal(s))


#-----------------------------------------------------------------
# Search strategy: Flailing Wildly
#-----------------------------------------------------------------
import random

random.seed() # use clock to randomize RNG

numSteps = 0
state = initialState
while not (goal(state) or feast(state)):
    numSteps = numSteps + 1
    print "\n%d: ======\nstate=%s" %(numSteps,describeState(state))
    rules = applicableRules(state)
    print "There are %d applicable rules" %(len(rules))
    for i in range(len(rules)):
        print str(i) + ": -- " + describeRule(rules[i])
    r = random.randint(0,len(rules)-1)
    print "Choosing rule[%s]=%s" %(r,describeRule(rules[r]))
    state = applyRule(state,rules[r])

print "Stopped at state %s" %(describeState(state))

