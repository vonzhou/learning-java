package thinkinginjava.generics;

// {CompileTimeError} (Won't compile)

interface Payable1<T> {
}

class Employee1 implements Payable1<Employee2> {
}

// 不能编译通过
//class Hourly1 extends Employee1 implements Payable1<Hourly1> {} 
