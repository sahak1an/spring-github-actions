#!/bin/bash

version='1.2.3.99'

increment_version ()
{
  declare -a part=( ${1//\./ } )
  declare    new
  declare -i carry=1

  for (( COUNTER=${#part[@]}-1; COUNTER>=0; COUNTER-=1 )); do
    len=${#part[COUNTER]}
    new=$((part[COUNTER]+carry))
    [ ${#new} -gt $len ] && carry=1 || carry=0
    [ $COUNTER -gt 0 ] && part[COUNTER]=${new: -len} || part[COUNTER]=${new}
  done
  new="${part[*]}"
  echo -e "${new// /.}"
}
increment_version $version
