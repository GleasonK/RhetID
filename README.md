#RhetID
_Rhetorical Analysis of Text for Author Identification_

RhetID analyzes your text for elements of famous authors to decide who you most wrtie like.

### Packages

#### POS

- The `pos` package is used to house all the Part of Speech tagging classes. 
- Note that part of speech tagging relies on the `.map` and `.set` files in PosFiles.

#### Zipf

- The `zipf` package is used to house all the classes for implementing Zipf's law.
- Note the implementation must take a word at a time to reduce algorithmic complexity.

#### Author

- The `author` package will house data types for holding authors statistics and trends.
- Will be done statically in the same manner as POS.

#### Elements
__Name Change Pending__

- The `elements` package will house the shorter algorithms to track various other elements of textual analysis.
- Likely will implement a data sructure that will analyze all elements in a single add function.

## Shakespeare

| Type  | Hamlet             | Macbeth            |
| ----- | -----------------  | -------------------|
| NN/S: | 2.250208507089241  | 2.8117859290438965 |
| PN/S: | 0.8237420072282458 | 2.2561635598316294 |
| PP/S: | 0.8215179316096747 | 0.761876127480457  |
| VB/S: | 1.2643869891576314 | 1.3878532772098617 |
| JJ/S: | 0.6396997497914929 | 0.6806975345760673 |
| RB/S: | 0.5440644981929386 | 0.5892964521948286 |
| Words:| 34852              | 20943              |
|Sentences: | 3597           | 1663               |
|AvgSent:| 9.689185432304699 | 12.593505712567648 |
| ./W   | 0.08097096292895672  | 0.06670486558754715    |
| ?/W   | 0.012423964191438082 | 0.011746168170749176   |
| "/W   | 9.181682543326064E-4 | 0.0023874325550303204  |
| !/W   | 0.009755537702283943 | 8.594757198109154E-4   |
| --/W  | 0.020056237805577873 |  3.819892088048513E-4  |
| ;/W   | 0.020056237805577873 | 0.0027694217638351715  |
| ,/W   |  0.09640766670492368 | 0.10108389437998376    |


## Jane Austen

| Type  | Pride and Prejudice| Emma               |
| ----- | -----------------  | -------------------|
| NN/S: | 3.515981012658228  | 3.0055988582720388 |
| PN/S: | 1.292879746835443  | 1.242726973323087  |
| PP/S: | 1.6463607594936709 | 1.5689976945877704 |
| VB/S: | 2.850632911392405  | 2.6112635854649247 |
| JJ/S: | 1.9474683544303797 | 1.859260072455813  |
| RB/S: | 1.5727848101265822 | 1.5955648259962674 |
| Words: | 126482            | 165231             |
| Sentences: | 6320          | 9109               |
| AvgSent:| 20.012974683544304| 18.13931276759249 |



