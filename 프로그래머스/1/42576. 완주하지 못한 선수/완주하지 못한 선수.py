def solution(participant, completion):
    hash_map = {}

    for name in participant:
        if name in hash_map:
            hash_map[name] += 1
        else:
            hash_map[name] = 1
    
    for name in completion:
        hash_map[name] -= 1
        
    for name in hash_map:
        if hash_map[name] > 0:
            return name
