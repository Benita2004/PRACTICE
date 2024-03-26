test_data <- read.csv("email_spam_test.csv")
train_data <- read.csv("emails_spam_train.csv")

#summary statistics
summary_stat <- summary(test_data)
word_count_sum <- summary(test_data[, -1])
print("This is the summary statistics for word count: ")
print(word_count_sum)



word_frequency <- colSums(test_data[, -1])# this finds frequency of each word
word_frequency <- word_frequency[nchar(names(word_frequency)) >=3]
sorted_word_frequency <-sort(word_frequency, decreasing =TRUE) # orders from most frequent word to least
top_20_words <-head(sorted_word_frequency, 20)
print("Top 20 most common words in spam emails: ")
print(top_20_words)


library(ggplot2)

word_frequency_df <- data.frame(Word = names(top_20_words), Frequency = top_20_words)

ggplot(word_frequency_df, aes(x = Word, y = Frequency))+
  geom_bar(stat = "identity", fill= "purple",color = "white")+
labs(title = "Top 20 most common words in spam emails",
     x = "Word", y = "Frequency") +
  theme(axis.text.x = element_text(angle = 45, hjust = 1))  # this rotates x axis for better readability

train_data <- read.csv(emails_spam_train.csv)
#summary statistics

summary_stat <- summary(train_data)
word_count_sum <- summary(train_data[, -1])
print("This is the summary statistics for word count: ")
print(word_count_sum)



train_word_frequency <- colSums(train_data[, -1])# this finds frequency of each word
train_word_frequency <- train_word_frequency[nchar(names(word_frequency)) >=3]
sorted_word_frequency <-sort(train_word_frequency, decreasing =TRUE) # orders from most frequent word to least
top_20_words <-head(sorted_word_frequency, 20)
print("Top 20 most common words in spam emails: ")
print(top_20_words)


library(ggplot2)

train_word_frequency_df <- data.frame(Word = names(top_20_words), Frequency = top_20_words)

ggplot(train_word_frequency_df, aes(x = Word, y = Frequency))+
  geom_bar(stat = "identity", fill= "gold",color = "white")+
  labs(title = "Top 20 most common words in  emails spam train",
       x = "Word", y = "Frequency") +
  theme(axis.text.x = element_text(angle = 45, hjust = 1))  # this rotates x axis for better readability

test_data <- read.csv("emails_spam_train.csv")
train_data<-read.csv("email_spam_test.csv")

 column_missingness <- colMeans(is.na(train_data))
 print("Column Missingness:")
 print(column_missingness)

 overall_missingness <- mean(rowSums(is.na(train_data)))
 print("Overall Missingness:")
 print(overall_missingness)

 if (mean(column_missingness) > 0.01) {
   imputed_data <- mice(train_data, m = 5)  # Impute 5 datasets
   train_imputed <- complete(imputed_data)
   print("Missing values imputed using mice():")
   } else {
    train_clean <- train[complete.cases(train_data), ]
    print("Missing values removed.")
     }

 z_scores <- apply(train[, -1], 2, function(x) (x - mean(x)) /sd(x))
 threshold <- 3
 outliers <- which(abs(z_scores) > threshold, arr.ind =TRUE)
 
 if(length(outliers) > 0) {
   print("Indices of Outliers:")
   print(outliers)
 }else{
   print("No outliers detected.")
 }
 
 
 correlation_matrix <- cor(train_data[, -1]) 
 heatmap(correlation_matrix, 
    main = "Correlation Heatmap of Predictor Variables",
    xlab = "Predictor Variables", 
    ylab = "Predictor Variables")
