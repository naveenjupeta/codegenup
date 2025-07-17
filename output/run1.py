from playwright.async_api import async_playwright

async def test_login_to_github():
    async with async_playwright() as p:
        # Launch the browser
        browser = await p.firefox.launch()
        # Open a new browser page
        page = await browser.new_page()

        try:
            # Open the GitHub login page
            await page.goto("https://github.com/login")

            # Enter the username
            await page.fill("#login_field", "naveennoni2429@gmail.com")

            # Enter the password
            await page.fill("#password", "Github@0310")

            # Click on the "Sign in" button
            await page.click("input[name='commit']")

            # Navigate to the "codegendev" repository
            await page.goto("https://github.com/naveennoni2429/codegendev")

            # Inside the repository, navigate to the "output" directory
            await page.goto("https://github.com/naveennoni2429/codegendev/tree/main/output")

            # Inside the "output" directory, navigate to the "programs" folder
            await page.goto("https://github.com/naveennoni2429/codegendev/tree/main/output/programs")

            # Inside the "programs" folder, open the "add_to_zero.py" file
            await page.goto("https://github.com/naveennoni2429/codegendev/blob/main/output/programs/add_to_zero.py")

            print("Test passed")

        except Exception as ex:
            print("Test failed, element not found.")
            print(str(ex))

        finally:
            # Close the browser
            await browser.close()

# Run the async function