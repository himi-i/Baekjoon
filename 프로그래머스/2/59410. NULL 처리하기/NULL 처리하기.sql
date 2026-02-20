SELECT 
    ANIMAL_TYPE,
    coalesce(NAME, 'No name') as NAME,
    SEX_UPON_INTAKE
from ANIMAL_INS;