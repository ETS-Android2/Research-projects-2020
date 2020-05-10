# Explore Data with Tableau
Table of content
1. Introduction 
2. Data visualzation  
3. Tableau
4. Tableau products
5. Tableau Features
6. Tableau Data sourcee
7. Analyzing COVID-19 Data using Tableau
8. Tableau COVID-19 Global Tracker

# 1. Introduction

Recently, human computer interaction is another discipline gaining a major attention from both users and data analyst experts. Interacting with various data formats requires not only an appropriate analysis technique
but also choosing the right tool plays a vital role to obtain the desired insights.
In this tutorial you will learn how to analyze data with [Tableau](http://tableau.com/) a leading Business Intelligence tool.
Tableau is one of the fastest growing data visualization tool in the Business Intelligence industry.
We choose tableau because it is perfect tool to create user friendly visualizations, to perform in-depth analysis for disparate data sources and manage and customize visualizations to answer user queries.


# 2.  What is Data Visualization?

Data visualization is the representation of data using visual elements such as such as charts, graphs, and maps. Visualizations simplify the way data is presented to the end users. More importantly, in today's increasingly data driven world, data visualization enables decision-makers of any enterprise to look into analytical reports and understand concepts quickly which might be difficult to grasp otherwise.

## Why is data visualization important?

Competition is tough in the current business landscape and challenging businesses with constant change which includes the need for information representation. It’s hard to think of a professional industry that doesn’t benefit from making data more understandable.
A visual summary of information simplifies the identification of patterns and trends in sharp contrast to looking through thousands of rows spread over a spreadsheet or csv file. It's the way the human brain works. Since the purpose of data analysis is to gain insights, data is much more valuable when it is visualized.
 - Visualization helps people to understand things clearly and have a better insight in a topic
 - Data visualization helps us to identify relationships and patterns within data
 - Data of large volumes can also be interpreted easily and quickly
 - It is a simple way to share ideas with others
 - Visualizing data enables analysis at various levels of detail
 - Data visualization conveys the information in a universal manner
 - Data Visualization amplifies your data and makes interpretation easy
 - Visualization helps to conceptualize and evaluate predictions to take better decisions
 - Data visualization lets people know where they need to do an adjustment in their business to get a better result
     
 
# 3.Tableau

Tableau is one of the most popular and powerful data visualizations tools which is created by Tableau software currently being used in various BI industries as their number one choice. It provides an easy drag and drop interface making it the best way to change or transform the raw data into an easily understandable format with almost zero technical skills and coding knowledge. The following features and statstics can answer that why [Tableau](https://mindmajix.com/tableau-best-bi-tool) is choosen as their primary tool over others visualization tools available on the market


![](/research/Images/Tableau_Why.PNG)



[Tableau](https://www.tableau.com/reports/gartner) is recognized as a Leader in the 2020 Gartner Magic Quadrant for Analytics and Business Intelligence Platforms 

![](/research/Images/Tableau_2020_Rank.jpg)

Also, the Gartner Magic Quadrant for selected business intelligence 2020 update shows that the evolution of [Tableau](https://exceleratorbi.com.au/extract-numerical-data-points-from-an-image/) from 2015 to 2020 with an amazing progress and placed on the top of the pool with Microsoft power BI and other popular tools.

![](/research/Images/Tableau_Ranking.png)



From the above three figure, we can easily understand that why Tableau is a popular BI tool.  As we can see from the animation within 5 years, Tableau shows an amazing progress in the BI industry and now it is the second most used tool next to microsoft power BI. 
  
  #### Tableau success stories of Enterprises
 Digital transformation is now seen as a key strategic initiative and business intelligence tools have evolved to help companies make       the most of their data investments. Below we listed a few success stories of [enterprises](https://www.tableau.com/learn/articles/business-intelligence-examples) using tableau as their BI platform 
  
  - **HelloFresh**: centralized digital marketing reporting to increase conversions
  -  **Coca-Cola**: Bottling Company maximized operational efficiency
      - **Problem**:Manual reporting processes restricted access to real-time sales and operations data.
      - **Solution**: A self-service BI implementation fosters more effective collaborations between IT and business users that maximize the expertise of participants and saving over 260 hours a year. Report automation and other enterprise system integrations through mobile dashboards that provide timely, actionable information and a distinct competitive advantage. 
  - **Chipotle**: created a unified view of restaurant operations
     - **Problem**: Disparate data sources hindered teams from seeing a unified view of restaurants.
     - **Solution**: They replaced their traditional BI with a sself-service BI platform  which allowed them to create a centralized view of     operations so they can track restaurant operational effectiveness over 2,400 locations worldwide. 
 - **Des Moines**: Public Schools identifies and helps at-risk students
   - **Problem**: Manual Excel reporting couldn’t see up-to-date data like attendance, preventing timely intervention 
   - **Solution**:Advanced analytics to improve dropout intervention rates to better understand the impact of various teaching methods on individual student outcomes
  - Amazon, Walmart ,World Bank, Citigroup, New York Times, and LinkidIn also use tableau  for their BI platform. 
  

# 4. Tableau Products

Tableau provides many tools which are important for various user cases:

- Tableau Desktop: This product is made for individual use.
- Tableau Server:  This server edition is designed to collaborately work on a given project
- Tableau Online: Tableau provides a cloud platform for Business Intelligence solutions
- Tableau Reader: Let you read files saved in Tableau Desktop.
- Tableau Public: This is a light verison of Tableau Desktop.<br/>

All Tableau products provide similar functionality with a subtle differences, beacause these products are designed to address different use cases. As a user to decide which product fits your requirements best, consider taking the following questions into account. <br/>
    1. Connectivity – What datasoure you want to access?<br/>
    2. Distribution – with whom do you want to share your dashboards, public or private? <br/>
    3. Automation – Instant update or schedule based update?<br/>
    4. Security – what security level do you want to apply to your dashboards or visualization?<br/

For preparting the tutorial we use both Tableau Desktop and Tableau Online.

# 5. Tableau Features

Why we use Tableau when there are a lot of tools available in the market to perform data visualization? <br/> 
Tableau is greatly used because any kind of data can be analyzed very quickly and it is used to explore data with limitless visual analytics. Moreover, without deep technical knowledge, we can perform starting from simple to advanced analytics by using its drag and drop functionally.

The following are some of the promising [Tableau features](https://intellipaat.com/blog/what-is-tableau/) that makes tableau a number one visualization tool to build BI solutions.

![](/research/Images/Tableau_Features.PNG)


  
In addition to the above features, newer Tableau editions support the following additional newerer [features](https://mindmajix.com/tableau-best-bi-tool). <br/>
  
![](/research/Images/New_Features.PNG)
  


# 6. Tableau Data Sources

One of the biggest advantages of Tableau over other business intelligence tools is its ability to connect to various data sources and ability to create advanced vidualization without any prior technical expertize  . Tableau provides a platform to perform edge catching for visualizations.The figure below clearly presents that tableau works with disparate data sources.

![](/research/Images/Data_Sources.PNG)

# 7. Tableau Practical: Analayzing a COVID-19 DataSet

In this section we explore the various features of the tool to create eye cataching visualizations and dashboards. 

## Task 0

### Create a Trial account

Go to the [Tableau](https://www.tableau.com/products/cloud-bi?openExternal=true#online-reg-form) homepage and create a free trial account. If you are working on windows or mac download the software. For linux users there is no desktop version you can use the webversion which is sufficient for most of this tutorial except the forecasting part.

## Task 1 Prepare your Data

### Task 1.1 Locate the data
 
The first step is to access ones data. Since we have no company data at hand we are going to select data from a machine-learning data repository such as [kaggle](https://www.kaggle.com/). This tutorial is based on this [dataset](https://www.kaggle.com/imdevskp/corona-virus-report) on covid-19 cases worldwise from january to today. Download the dataset and open it. Understand the data by looking at the column and row headers to explore suitability for analysis and get a feeling for the potential of the data. Consinder whether the data is wide data (Wide data data with many columns fewer lines) or skinny data (Skinny data data with few columns many lines). Also start thinking what type of analysis is suitable to be performed on this data.  

### Task 1.2 Load data into Tableau

To import locally stored data into tableau workspace follow the following steps:
1. Create  new workbook
2. Click on the file menu and select open
3. Navigate to the data location and import it.
4. Drag to the workspace area and start exploring.

When you import data into tableau, the tableau [workspance](https://www.guru99.com/introduction-tableau-workspace-navigation.html) looks like as shown below. There might be some difference  when you use different tableau products and versions. 
![](/research/Images/Workspace.PNG)

Figure: Tableau Interface(WorkSpace)
   
To start analysing the data , it is good idea to understand your data formats. The following icons represent the different data types in tableau.
 
![](/research/Images/Data_Icons.PNG)

##### Measures and Dimensions in Tableau

From the above figure, we can see different symbols which corresponds to different data types. Any data imported into tableau are categorized either as a measure or a dimension.
**Measures** contain quantitative values that you can measure and use these fields necessary to perform various aggregation.<br/>
**Dimensions**,on the other hand, contain qualitative values. Dimensions are used to categorize, segment, and reveal the details in the data and determine the level of visualizations such as slicing, and drill down operations.<br/>
When you import data tableau automatically categorize each fileds into dimensions and measures, but user can customize it. When the data is successfully imported the data will looks like as depicted below  

![](/research/Images/Dimenisions_Measures.PNG)
 
Figure:Measures and Dimensions


#### Combine Data from different sources:
If your analysis depends on single data source, this step may not be necessary. However, in reality you easily get in the situation of dealing with multiple files. In this case to follow the provided steps are required.
1. Drop the the source files into working book
2. Specify the columns to join on 
3. Join the files by selecting anyone of the following join types<br/>
  
    ![](/research/Images/Join_types.PNG)

## Task 2 Create Visualizations

Tableau is enriched with many types of possible visualizations. Transforming data into an effective visualization is essential in making your analysis have impact. The type of visualization to choose depends strongly on the data you have on hand and trend you want to see.  Therefore, it is of utmost importantance to smoothly integrate data and visualization types to get a better insight about your data.
The most commonly used graphs and charts are:<br/>
-	Bar Chart- Charts mainly designed to quickly compare data across categories, highlight differences and reveal historical highs and lows
-	Line Chart- mostly used to show continuous evaluations of data 
-	Pie Chart- are useful to add details to other visualizations 
-	Maps- Are particularly important to visualize location and geosptial data
-	Scatter plot- is important to show relationships between different variables


In the data pane on the left side you can see the column headers of the data we imported. You can simply create visualizations by drag and drop from the data pane in to the field title.<br/>

![](/research/Images/Show_Me.PNG)

*One very nice  feature about Tableau is that by default it selects the convenient visualization type(charts/graphs) for your data based on the selected selected measures and dimensions.*  

### Task 2.1 Create a world map

An obvious question we could try to answer with our data is, how did covid 19 spread around the world.
The first step to create a new visualization is to create a new sheet in your workbook, click on the respective icon on the bottom or press ctrl+alt+t. If you are unsure which type of visualization might be applicable to analyze the given data the 'Show Me' button on the top right corner is a good tool to explore your options. To use this functionality drag a header from the data pane to into the row or colum section. 

#### Task 2.1.1 Drag your columns and rows into the sheet

In our case let's take date as columns, countries and sum of confirmed cases for size in marks. Now you can see all possible options how to display your data by clicking on the 'Show Me' button on the top right corner. Select the map. This selection will generate one world map for every day in our data, presenting the cumulative confirmed infections of every country per day.

![](/research/Images/world_map1.png)

At the moment the granularity for date is set to years which is not helpful in our case. Set it to days because the data we imported is already representing sums on a daily basis.

![](/research/Images/world_map2.png)

### Task 2.1.2 Apply filters

Taking a look at the map we generated we see a lot of dots with the value 0. We can exclude these values by a filter. To do that click on the sum confirmed field and enable show filter. Now you can see a slider on the right hand side of the window in the legend. You can either use the slider or click on the numbers above to modify the value. Let us exclude the zero values by setting the minimum number of confirmed cases to 1.

![](/research/Images/world_map3.png)


### Task 2.2 Create a trendline

Another question we may ask is how are individual countries developing over time?
To investigate this question you can create a graph displaying trendline of deaths confirmed and recovered filtered after individual countries.

#### Task 2.1.1 Drag your columns and rows into the sheet

In the same way as before drag and drop the desired attributes into columns, once more the data in days. For rows select deaths, confirmed cases (confirmed) and recovered. 

#### Task 2.1.3 Apply filters and colors

Dragging and dropping the icon country/region over color we can colorize the different lines. You can change the color scheme by clicking on the color button as you see fit. Now to filter for individual country you once again enable show filter. Enabling a filters displays a long list which is taking a lot of space in the legend. By expanding the icon in the top right corner in the country/region box we can transform the filterlist to for example a dropdown menu with multiple values. First unselect All, then select a few countries of your choice for example China, Italy, Spain and the US.

![](/research/Images/trend1.png)

![](/research/Images/trend2.png)

 ## Task 3: More Specific visualization
 
If you are interested in to visualize COVIF 19 spread for a specific country or state, it is possible to focus on small part of the data.
This visualization focuses on the number of cases and deaths on the different US states in order to see the trends how COVID-19 spread over time in various US states.  One of the great features that Tableau providing us is the capability forecasting based on existing data. We made a forecast of the number of deaths and cases for one month based on four months data.
The shadow area in the line graph represents the forecasted values for May 2020.
Steps
1.	Drag and drop required dimensions and measures into the rows and columns section
2.	Drag and drop country into the filter section and select US and show the filter 
3.	Drag and drop states/province  into the cards  color section and show the filter
4. In the filter area,select the states you want to see the past  and forcast trend.In our case we choose to focus only to five states (New York, New Jersey, Califorina, Texas, )<br/>

![](/research/Images/Trend_US_State.PNG)

Figure: Number of Confirmed cases and deaths of US states
## How to apply forcasting to visualization

Forcast is one of the great features offered by tableau which enables us to predict the number of cases and deaths for future. This helps us to see how the number of deaths and cases will look like in the future. The forcast period depends on the history of the available data. In the COVID-19 data, We have data for since February 2020 upto now. so, we can able to perform forcast for the upcoming three months, but in the above graph we only showed forcast of one month to make things easier to understand. In tableau , by defualt, forcasting feature is not enablead, so, to do forcasting follow the following steps.
1. Turn on forcating feature from the Analysis menu
2. Decide the forcasting granuality 

![](/research/Images/Forcast.png)

Figure: Applying forcast feature in Tableau


## Task 4 Create a Dashboard

To use our visualizations for monitoring or presentation we can combine multiple visualizations in a dashboard.
Create a new dashboard by clicking the respective button at the bottom of the window right next to new sheets.
You can add the visualizations created before by drag and drop the respective sheet from the left side. You can also add titles for the sheets you added as well for the whole dashboard. Furthermore, Tableau allows you to add various objects to customize your dashboard such as text, images or webpages. You will find these options in the bottom left corner. Your dashboard could look like this:

![](/research/Images/dashboard.png)

# 8. Tableau COVID-19 Global Tracker Dashboard

COVID-19 case data is the most important data right now. BI and tech companies in general are working tirelessly to provide interactive visualization on the spread of coronavirus and let the users get informed about the pandemic to reduce the impact as much as possible. Tableau is providing a daily global coronavirus tracker to help you stay updated on the confirmed case, total deaths, and the places most impacted by the pandemic with an interactive [dashboard](https://www.tableau.com/covid-19-coronavirus-data-resources) at various granularity levels as shown below. Following the link you can play with the dashbord. From the dashboard, we can understand that tableau is not only a visualization tool but also an advanced analytics tool .<br/> 
![](/research/Images/COVID-19.PNG)




Resources
1. https://intellipaat.com/blog/what-is-tableau/
2. https://evolytics.com/blog/tableau-product-best/
3. https://www.educba.com/data-visualization-with-tableau/
4. https://www.tableau.com/covid-19-coronavirus-data-resources
5. https://www.tableau.com/learn/get-started
6. https://www.tableau.com/reports/gartner
7. https://intellipaat.com/blog/7-enterprises-using-tableau-with-big-success/
8. https://www.tableau.com/learn/articles/business-intelligence-examples
9. https://mindmajix.com/tableau-best-bi-tool




