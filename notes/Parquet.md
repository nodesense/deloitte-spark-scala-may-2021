CSV / JSON / XML, ... flat files , all are row based

movieId,title,genres
1,Toy Story (1995),Adventure|Animation|Children|Comedy|Fantasy
2,Jumanji (1995),Adventure|Children|Fantasy
3,Grumpier Old Men (1995),Comedy|Romance
4,Waiting to Exhale (1995),Comedy|Drama|Romance
5,Father of the Bride Part II (1995),Comedy
6,Heat (1995),Action|Crime|Thriller



filter (movieId == 6)

Row Pros 
    readable for human
    edit using tools like excel

cons
    we don't get good compression ratio
    it won't optimize the data size
    scans are expective, read whole data and pick few
#####

Encoding

1,India
2,India
3,India
4,India

Dict Encoding to reduce/repeative data

{
 India - 1
    USA - 2
 France - 3
 Canada - 4
}

encoded now
id, country
1,1
2,1
3,1
4,1
5,2

Parquet 
    Column
    Binary format
    column types
        
        movieIds: [1, 2,3,4,5,6]
        title: [Toy Story (1995), Jumanji (1995), Grumpier Old Men (1995)]
        genres: .......

select movieId from movie_table
df.select("movieID) , or filter ( movieId > 4)