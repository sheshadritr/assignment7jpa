
from itertools import count
from stackpy import Site, API
import MySQLdb


def callSOAPI():

    # Fill in the strings with the appropriate values:
    API.key = "3e9HSC1)4QX3UyfjUJM3QQ(("
    API.client_id = "3279"
    API.client_secret = "qp5sfEHt6j*NmEbagTaieQ(("

    # Create an object that represents the site
    site = Site('stackoverflow', API)

    # Open database connection
    dbconnection = MySQLdb.connect(host = "localhost", user = "root", passwd = "hasher123", db = "questionbase")

    # prepare a cursor object using cursor() method
    dbcursor = dbconnection.cursor()

    # Create database tables to store the json objects of questions
    create_questiontable(dbcursor)
    create_tagtable(dbcursor)
    #create_questiontagtable(dbcursor)

    # Fetch all the questions page wise, in for loop
    for pagecount in count(1):
        questionlist = site.questions.tagged('angularjs').page(pagecount)
        for questionentry in questionlist:
            insert_question(dbcursor, questionentry)
            insert_tag(dbcursor, questionentry)
            dbconnection.commit()
        if not questionlist['has_more']:
            break

    # Updates the value of coloumn named year, that corresponds to year of createdDate.
    update_year(dbcursor)

    # commit transactions
    dbconnection.commit()

    # close cursor and connection
    dbcursor.close()
    dbconnection.close()


def create_questiontable(dbcursor):

    query = """CREATE TABLE question (
            questionId  int(100) NOT NULL,
            questionTitle  varchar(500) NOT NULL,
            questionLink varchar(500) NOT NULL,
            isAnswered varchar(10) NOT NULL,
            viewCount int(10),
            answerCount int(10),
            score int(10),
            lastActivityDate datetime NOT NULL,
            creationDate datetime NOT NULL,
            year int(4) NOT NULL;
            PRIMARY KEY (questionId)
    ) ENGINE = INNODB"""
    dbcursor.execute(query)


def create_tagtable(dbcursor):

    query = """CREATE TABLE tags (
            tagId  int(100) NOT NULL AUTO_INCREMENT,
            tagName varchar(50) NOT NULL,
            questionid_questionId int NOT NULL,
            PRIMARY KEY (tagId),
            FOREIGN KEY (questionid_questionId)
                REFERENCES question(questionId)
                ON DELETE CASCADE
    ) ENGINE = INNODB"""
    dbcursor.execute(query)


def insert_question(dbcursor, questionentry):
    qid = questionentry.question_id
    qtitle = questionentry.title.encode('utf-8')
    qlink = questionentry.link.encode('utf-8')
    qis = questionentry.is_answered
    qview = questionentry.view_count
    qans = questionentry.answer_count
    qscore = questionentry.score 
    qlad = questionentry.last_activity_date
    qcd = questionentry.creation_date
    #check that the question doesn't exist before
    check = """select count(*) from question where questionId = %s"""
    dbcursor.execute(check, qid)
    result = dbcursor.fetchone()
    found = result[0]
    if found == 0:
    	query = """INSERT INTO question(questionId, questionTitle, questionLink,
            isAnswered, viewCount, answerCount, score,
            lastActivityDate, creationDate)
            VALUES (%s, %s, %s, %s, %s, %s, %s, %s, %s);"""
        dbcursor.execute(query, (qid, qtitle, qlink, qis, qview, qans, qscore, qlad, qcd))


def insert_tag(dbcursor, questionentry):
    for tag in questionentry.tags:
    	tqid = questionentry.question_id
    	#check that the question doesn't exist before
        check = """select count(*) from tags where questionid_questionId = %s and tagName = %s"""
        dbcursor.execute(check, (tqid, tag))
        result = dbcursor.fetchone()
        found = result[0]
        if found == 0:
            query = """INSERT INTO tags(tagName, questionid_questionId) VALUES (%s, %s)"""
            dbcursor.execute(query, (tag, tqid))

def update_year(dbcursor):
	dbcursor.execute("""update question set year=YEAR(creationDate)""")

callSOAPI()


'''
description: Dashboard for angularjs questions over time
oauth domain: hashedin.com
application website: hashedin.com
'''
