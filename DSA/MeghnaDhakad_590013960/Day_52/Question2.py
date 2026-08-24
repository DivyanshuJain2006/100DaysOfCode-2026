def process_registrations(requests: list[str]) -> list[str]:
    database = {}
    results = []
    
    for name in requests:
        if name not in database:
            # Register the name and set the next available suffix to 1
            database[name] = 1
            results.append("OK")
        else:
            # Name exists, find the next valid suffix
            k = database[name]
            new_name = f"{name}{k}"
            
            # Handle edge case: Ensure the generated name hasn't been manually requested before
            while new_name in database:
                k += 1
                new_name = f"{name}{k}"
            
            # Update the next available suffix for the base name
            database[name] = k + 1
            # Register the newly minted name so it can't be taken
            database[new_name] = 1
            
            results.append(new_name)
            
    return results