//we are going to briefly talk about the 3 ways you can declare a string

let s = 'you an make a string with single quotes, this is convinient if you need to include " in the string like for text"'
let s2 = "you can make as string using double quotes, you if have lot's of possisives/ contractions this is useful,you can always escape\" "
let s3 = `you can use a back tick
this is the most superior kind of string
it is called a template literal
js takes this template and converts it into a string once it is used
this allows for some very cool features like multi line strings
we can also directly embedded js expressions using ${(10 + 20)/100}
as you might be able to guess, this can be phenomally useful
you should use a template literal anywhere you need a non trivial string`

console.log(s3)