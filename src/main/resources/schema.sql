CREATE TABLE IF NOT EXISTS topic (
  id SERIAL PRIMARY KEY,
  title VARCHAR (128) NOT NULL UNIQUE,
  description TEXT,
  additionalSource VARCHAR (255),
  complete BIT,
  creationDate Date,
  completionDate Date);

