


            # If the matching type is 'email_phone'
            elif self.matching_type == 'email_phone':
                email2 = None
                email1 = None
                phone2 = None
                phone1 = None
                min_id = None

                # Check if email columns exist
                if self.email_col_2:
                    email2 = row[self.email_col_2]
                if self.email_col:
                    email1 = row[self.email_col]

                # Check if phone columns exist
                if self.phone_col_2:
                    phone2 = self.format_phone(row, self.phone_col_2)
                if self.phone_col:
                    phone1 = self.format_phone(row, self.phone_col)

                # Check if either email or phone is in ids dictionary, get the value
                if email2 in self.ids or email1 in self.ids or phone2 in self.ids or phone1 in self.ids:
                    email2_exists = self.ids.get(email2)
                    email_exists = self.ids.get(email1)