# Threading

What is it + principles

* Threads are subsets of a process
* Shared state and resources (memory, address space, etc.)

## How languages implement threading

* Native vs. Green
  * Native: the OS implements a threading model and the language takes advantage of it
  * Green (aka user threads): the language simulates threading through through its own scheduler. Execution is still performed within a single thread.
* 1:1, N:1, N:M
* Interpreted languages
  * GIL
* At least one thread per process at the OS level (you typically don't notice)
* Thread scheduling
  * Preemptive vs. Cooperative
  * Fibers; co-routines

## Thread safety

Re-entrant code, mutual exclusion, atomicity, thread-locals

* Know how you're code will execute
* Control your access to data inside and outside a thread
* Pay attention to thread scheduling
* What guarantees you have

* Priority inversion

OO problems with thread-local (personal). It's like using a global. Leads to bad design (example). Unable to determine the API if the same variable is used in multiple places. Use wisely.

Dining Philosophers

## Examples

Point out language differences

* Basic threading
* Thread vs. Fiber

## JavaScript

* actor-based control flow, erlang, etc.

## Testing

