#!/usr/bin/env bash


fail() {
echo "There were errors"
}

end() {
echo "Work is finished"
}



go_to_website () {
 if open http://localhost:8080/tasks; then
   echo "Website is loading"
 else
  echo "Sorry. Something goes wrong"
    fail
 fi
}

if ./runcrud.sh; then
  go_to_website
else
  fail
fi