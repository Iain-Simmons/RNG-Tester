library(reshape)
library(ggplot2)

setwd("C:\\Users\\Model\\workspace\\RNG Tester")
data<- read.csv("testFile.csv")
head(data)
melted = melt(data)
head(melt)
ggplot(melted, aes(x = value, colour=variable)) + geom_density()