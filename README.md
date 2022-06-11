# GenericAlgoirthm
Implementation of Generic Algorithm
## Introduction
Evolutionary algorithms are an optimization method that is based on the observation of nature; more specifically the process of evolution of species. These methods work well for analyzing multiple samples simultaneously. Evolutionary algorithms are based on a random search for the best solution and remembering it. Evolutionary algorithms exemplify an approach where random selection is just a search aid tool in a coded solution space.
Evolutionary algorithms are characterized by:
1. They do not process the task parameters directly, but their coded form
2. They search the solution area from a certain population
3. They only use the objective function, not its derivatives or other auxiliary information
4. Apply probabilistic selection rules

## Teminology:
**Population** = a set of individuals with a certain number of people

**Individuals** = solutions encoded in the form of chromosomes. Referred to as search space points

**Chromosome** = chain, code sequence - ordered sequence of genes

**Gene** = a single element of a genotype, particularly a chromosome

**Genotype** = the individual's chromosome complex. The individuals of the population can be genotypes or single chromosomes

**Phenotype** = decoded value corresponding to the given genotype.

**Allele** = value of a given gene, also known as trait value, trait variant

**Locus** = position indicating the location of a given gene on the chromosome chain.

**Adaptation function** = a measure of the fitness of a given individual in the population. Extremely important, as it allows to assess the degree of adaptation of individual individuals in the population and on this basis to select individuals that are best adapted. It has a great influence on the operation of evolutionary algorithms.
In the evolutionary algorithm, in each of its iteration, the adaptation of each individual of a given population is assessed using the adaptation function, and on this basis a new population of individuals is created (a new set of potential solutions to the problem)

## Generic Algorithm's steps:
The algorithm consists of the following steps:
1. selection of the initial chromosome population (initiation)
2. assessment of the chromosome adaptation in the population
3. checking the condition of detention
4. selection of chromosomes
5. application of genetic operators
6. creating a new population
7. Derivation of the best adapted chromosome

## Generic Algorithm's stages:
**Initiation**: Creates an initial population by randomly selecting a given number of chromosomes as binary strings of a specific length (MI)

**Adaptation assessment**: It consists in calculating the value of the fitness function for each individual. When maximization is sought, the higher the value of the function, the better the quality of the chromosome.
When one strives for the minimum, it should be reduced to the problem of seeking the maximum.

**Checking the stop condition**: The condition for which the algorithm is to be stopped is defined in advance. It can be: the number of evaluations, the number of generations, the limit value to which the function value should aim, etc. The algorithm may be stopped if its further operation does not improve the values already obtained. If the stop condition is met, the best-adapted solution is derived. If you do not proceed to the next step.

**Selection**: Selecting, on the basis of the calculated values of the chromosome adaptation function, those that will go to the next population of descendants. This choice complies with the principle of natural selection. The better the match, the better the chances of survival.
One of the most basic selection methods is the Roulette Method. It consists in determining the appropriate part of the circle for a given solution. This part is responsible for the probability of drawing a given solution; the larger the roulette piece has a given solution, the greater the chance of choosing it

**Creation of a new population:**
The new population will include the children of the parents selected at the selection stage as well as the parents themselves. If the final condition is not met, this child population will be used to repeat the entire algorithm.

**Getting the best solution:**
If the end condition is met, the best solution will be drawn.
You also have to take into account that the evolution algorithm may freeze; that is, the value of the best solution will not be different from the previous one. In this case, it is necessary to assess whether the returned solution is the optimal one.

### Genetic operations:
There are 2 major genetic operations:

**Mutation Operator**:
Mutation is a very rare occurrence. Thanks to mutation, one moves from one area of potential solutions in a global sense. It consists in changing the value of a gene to the opposite. Hence its probability is quite low.
Typically the probability is in (0 <= pm <= 0.1).
The mutation is made either before crossing on the parent population or after on the child population.

**Crossover operator**:
Responsible for the exchange of genes between two parents to create their descendants.
Crossing can be single point or multi point. Parents as well as crossing point / points are drawn. The crossing point (s) for both parents are the same / are the same. Then, on their basis, the process of gene replacement is carried out.
The crossover operator makes it possible to traverse the space of potential solutions in a local sense. Therefore, a crossover event is more likely to occur than a mutation event



