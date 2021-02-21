# TDL [75.31-95.07]

| Padrón | Alumno                    |
|--------|---------------------------|
| 104105 | Jonathan David Rosenblatt |
| 103545 | Matías Alberto Venglar    |
| 104348 | Joaquín Betz              |
| 103924 | Joaquín Fontela           |

### Requirements for Linux users:

- For the npm package manager run: `sudo apt install npm`

- Install TypeScript: `npm install typescript`

- Install the TypeScript compiler: `npm install tsc`

- To crate a React proyect with Typescript run: `npx create-react-app <APPNAME> --template typescript`

- Read files line by line: `npm install --save n-readlines`

- Discord module: `npm install discord.js`

- Read environmental variables: `npm install dotenv`

- Compile .ts project: `npx tsc --jsx react-jsx`

- Run Discord bot: `npm run start`

- Run React App: `npm run start --prefix src/react/my-app`

- To create the server: `npm install express`

# The TypeScript Language

TypeScript is a JavaScript superset and therefore they share many features such as variable declaration, API's usage, and more.

## Variables:

You can declare variables in TypeScript with: _var_, _let_ and _const_.

- Const allows you to declare global variables that cannot be reassigned. They must also be initialized.
- Var creates a variable that lives globally within a function or global scope.
- Let, in the other hand, creates a variable that only lives locally within a scope.

## Types:

One could guess from the name of the language that types are important here. One of TypeScript's most important features, and maybe even the most important, it's their typing system. 

TypeScript is this sort of a "Strongly Typed JavaScript" meaning that each variable needs to be declared under a specific type. This excelent feature allows the software to check for the validity of operations, assignments, potential errors caused due to changing types and more.   

### Boolean:

`let aprueboProba: boolean = false;`

### Numbers:

All numbers are either floating point (_number_ type) or bigint types (_bigint_ type):

`let decimal: number = 6;`

`let hex: number = 0xf00d;`

`let binary: number = 0b1010;`

`let octal: number = 0o744;`

`let big: bigint = 100n;`

### String:

Every string shall be wrapped around single or double quotes:

`let salute: string = "Sup";`

### Arrays:

There are two ways of declaring arrays:

`let list: number[] = [9, 99, 999];`

`let list: Array<Number> = [999, 99, 9];`

They can also be readonly:

`let list: ReadonlyArray<Number> = [999, 99, 9];`

### Tuples:

With tuples you can have a fixed number of variables stored in the same place, as long as the compiler know what type does each position of the tuple have.

`let tupla: [string, number] = ["Working", 1];`

💥 `tupla = [404, "This ain't working dawg."];` 💥

### Enums:

You can manually set the how you access each member of the enum, by changing its index.

```
enum Animal {
    dog, 
    cat,
}
...
let a: Animal = Animal[1] // 🐈
```

```
enum Animal {
    dog = 1, 
    cat,
}
...
let a: Animal = Animal[1] // 🐕
```

### Unknown:

Variables with unknown types can have any kind of value stored into them, at any part of the program execution.

`let mysterious: unknown = ...`

It is also useful to know what the `typeof` check will return you a string value which corresponds to the variable type. This can come in handy when dealing with unknown types.

### Any:

Let's you bypass the typing check. One could say that, unlike unknown, _any_ variables have no type. Avoid unless it is necessary.

### Void:

Only useful when a function does not return any kind of value, or when a variable is either _null_ or _undefined_.

### Never:

Declares something that _should_ never happen. Useful to raise errors.

`let boom: never = (() => { throw new Error("Oh crap") })();`

### Object:

Object is a type that reresents anything that is not number, string, boolean, bigint, symbol, null, or undefined.

### Union Types:

If you know that a variable can only have certain types, then you can name them between pipes:

`let stringornumber: string | number = ...;`

Or even certain values:

`let dice: 1 | 2 | 3 | 4 | 5 | 6;` 

### Intersection Types:

Let's you have the properties of every entity referenced:

`let explosiveFork: fork & bomb;`

### Type Casting:

You can cast types with _as_:

`let something: unknown = "this is a string";`

`let len: number = (something as string).length;`

And with the “angle-bracket” syntax:

`let something: unknown = "this is a string";`

`let len: number = (<string>something).length;`

### Readonly:

Keeps members readonly, obviously.

### Interface:

Describes objects that must have a certain member (all public): 

```
interface LabeledValue {
  label: string;
}

let myObj = { size: 10, label: "Size 10 Object" };
```

If a property is not always requiered, you can describe this by adding a ? at the end of it:

```
interface CoffeeBox {
  readonly label: string;
  readonly expired: boolean,
  readonly discountcode?: string,
}
// They can also be readonly properties.
```

Interfaces can inherit properties from anothers:

```
interface Animal {
  name: string;
}

interface Dog extends Animal {
  breed: string;
}
```

### Classes:

Classes that implement interfaces must follow it's contract. These can have non-public properties.

interface ClockInterface {
  currentTime: Date;
}

class Clock implements ClockInterface {
  currentTime: Date = new Date();
  constructor(h: number, m: number) {}
}

Extending a interface (or many, which is possible) copies its properties to the class instance. 

### Rest Parameters:

Variables can have an unknown number of values you can use:

```
function buildName(firstName: string, ...restOfName: string[]) {
  return firstName + " " + restOfName.join(" ");
}

// employeeName will be "Joseph Samuel Lucas MacKinzie"
let employeeName = buildName("Joseph", "Samuel", "Lucas", "MacKinzie");
```

