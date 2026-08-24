def first_invalid_record(records):
    seen = {}

    for i, record in enumerate(records):
        vendor_id, lot_number, cert_code = record
        key = (vendor_id, lot_number)

        if key in seen:
            if seen[key] != cert_code:
                return i
        else:
            seen[key] = cert_code

    return -1


# Input
n = int(input("Enter number of records: "))

records = []
for _ in range(n):
    vendor_id, lot_number, cert_code = map(int, input().split())
    records.append([vendor_id, lot_number, cert_code])

# Output
print(first_invalid_record(records))